/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.tag;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 * Created by lvxi on 2017/2/24.
 * Note:
 */
public class HelloTag implements Tag{
    private PageContext pageContext;
    private Tag parentTag;
    public void setPageContext(PageContext pageContext) {
        this.pageContext=pageContext;
    }

    public void setParent(Tag tag) {
        this.parentTag=tag;
    }

    public Tag getParent() {
        return parentTag;
    }

    public int doStartTag() throws JspException {
        return Tag.SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        JspWriter jspWriter =pageContext.getOut();
        try {
            pageContext.getRequest().setAttribute("lvxi","lvxi");
            pageContext.include("cs.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jspWriter.println("<h1 style=\"color:red\">Just do it!</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

    public void release() {

    }
}
