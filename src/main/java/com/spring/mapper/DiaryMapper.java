package com.spring.mapper;

import com.spring.entity.DiaryDO;

import java.sql.SQLException;
import java.util.List;

/**
 * dao - diary
 *
 * @auther ten
 */
public interface DiaryMapper {
    /**
     * 日记上传 :
     * 插入DiaryDO到diary表
     * 返回自增长主键diary_id
     *
     * @param diaryDO diaryDO
     * @return diary_i
     */
    int insertDiaryAndGetKey(DiaryDO diaryDO);

    /**
     * 日记更新 :
     * 根据diary_id进行内容的更新
     *
     * @param diaryDO diaryDO
     *                e
     */
    void updateDiary(DiaryDO diaryDO);

    /**
     * 日记删除 :
     * 根据diary_id进行删除
     *
     * @param diaryId diaryId
     *                e
     */
    void deleteDiaryById(Integer diaryId);


    /**
     * 日记单个查询 :
     * 通过diary_name(uk)进行查询
     * 获取数据库diary信息
     * diary信息封装在DiaryDO中返回
     *
     * @param diaryName 图片名
     * @return DiaryDO DiaryDO
     * @throws NullPointerException 记录不存在
     */
    DiaryDO queryDiaryByName(String diaryName);

    /**
     * 日记全部查询 :
     * 通过user_id进行查询
     * 获取数据库diarylist信息
     * diarylist信息封装在{@literal List<DiaryDO>}中返回
     *
     * @param userId 用户ID
     * @return {@literal List<DiaryDO> List}
     * @throws NullPointerException 记录不存在
     */
    List<DiaryDO> queryDiaryListByUserId(Integer userId);
}
