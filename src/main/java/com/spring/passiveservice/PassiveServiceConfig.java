package com.spring.passiveservice;


import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HUANGHAO
 */
public class PassiveServiceConfig {
//	public String name = ""; // 外部服务名
//	public String value = "";// 匹配key值字符串
//	public String description = "";// 外部服务说明
//	public String price = "";// 外部服务价格
//	public String position = ""; // 出现位置
//	public String compulsory = "";

    /**
     * 加载被动推送配置文件
     *
     * @return List<Map       <       String       ,               Object>>
     */
    public static List<Map<String, Object>> loadConfigS() {
        List<Map<String, Object>> configList = new ArrayList<>();
        try {
            InputStream is = Utils.GetCurrentResourcesStream("passiveservice/passiveservice.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element xRoot = doc.getRootElement();
            List<Element> propertys = xRoot.elements("property");
            for (Element element : propertys) {
                Map<String, Object> configS = new HashMap<>(10);

                Node name = element.selectSingleNode("name");
                Node value = element.selectSingleNode("value");
                Node description = element.selectSingleNode("description");
                Node price = element.selectSingleNode("price");
                Node position = element.selectSingleNode("position");
                Node compulsory = element.selectSingleNode("compulsory");

                configS.put("serviceName", name.getStringValue());
                configS.put("serviceValue", value.getStringValue());
                configS.put("description", description.getStringValue());
                configS.put("price", price.getStringValue());
                configS.put("position", position.getStringValue());
                configS.put("compulsory", compulsory.getStringValue());

                configList.add(configS);
            }

        } catch (Exception e) {
            ResultUtils.throwException(e.hashCode(), e.getMessage());
        }
        return configList;
    }

    /**
     * 获取方案固定价格
     * @return
     */
    public static BigDecimal getSolidPrice(){
        BigDecimal solidPrice = new BigDecimal(0) ;
        try {
            InputStream is = Utils.GetCurrentResourcesStream("passiveservice/passiveservice.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element xRoot = doc.getRootElement();
            List<Element> propertys = xRoot.elements("property");
            for (Element element : propertys) {
                Node price = element.selectSingleNode("price");
                Node position = element.selectSingleNode("position");

                if(Integer.parseInt(position.getStringValue())==-1){
                    solidPrice = solidPrice.add(new BigDecimal(price.getStringValue()));
                }
            }
        } catch (Exception e) {
            ResultUtils.throwException(e.hashCode(), e.getMessage());
        }
        return solidPrice;
    }

    public static void main(String[] arg) {
        List<Map<String, Object>> maplist = loadConfigS();
        System.out.println(maplist);
    }

}
