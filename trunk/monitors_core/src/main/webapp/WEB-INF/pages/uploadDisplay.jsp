<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="display.title"/></title>
    <meta name="heading" content="<fmt:message key='display.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<p>Below is a list of attributes that were gathered in UploadAction.java.</p>

<div class="separator"></div>

<table class="detail" cellpadding="5">
    <tr>
        <th>Filename:</th>
        <td><s:property value="fileFileName"/></td>
    </tr>
    <tr>
        <th class="tallCell">File Location:</th>
        <td>The file has been written to: <br />
            <a href="<c:out value="${link}"/>">
            <c:out value="${link}" escapeXml="false"/></a>
        </td>
    </tr>  
    <tr>
        <td></td>
        <td class="buttonBar">
            <input class="button" type="button" value="Done"
                onclick="window.parent.tb_remove(); return false;" />
        </td>
    </tr>
</table>



