<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.newenv.communityFocus.security.SecurityUserHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    
    Integer cityId = SecurityUserHolder.getCurrentUserLogin().getDepartment().getCityId();
    Integer prefId = SecurityUserHolder.getCurrentUserLogin().getUserProfile().getId();
    Integer departmentId = SecurityUserHolder.getDeptId();
%>

