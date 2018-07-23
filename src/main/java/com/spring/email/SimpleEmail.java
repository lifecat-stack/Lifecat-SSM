package com.spring.email;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class SimpleEmail {
    /**
     * 收件人
     */
    private Set<String> toSet;
    /**
     * 主题
     */
    private String subject;
    /**
     * 正文
     */
    private String content;
    /**
     * 正文是否是HTML
     */
    private boolean isHtml;
    /**
     * 附件路径
     */
    private Map<String, File> attachments;
    /**
     * 是否有附件
     */
    private boolean isAttachment;

    public Set<String> getToSet() {
        return toSet;
    }

    public void setToSet(Set<String> toSet) {
        this.toSet = toSet;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public Map<String, File> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, File> attachments) {
        this.attachments = attachments;
    }

    public boolean isAttachment() {
        return isAttachment;
    }

    public void setAttachment(boolean isAttachment) {
        this.isAttachment = isAttachment;
    }

}
