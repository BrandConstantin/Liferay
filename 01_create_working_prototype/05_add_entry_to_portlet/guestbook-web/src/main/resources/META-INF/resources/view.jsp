<%@ include file="/init.jsp" %>

<!-- REMOVE UNDER THIS -->
<!-- <p>
	<b><liferay-ui:message key="guestbook.caption"/></b>
</p> -->

<portlet:renderURL var="addEntryURL">
    <portlet:param name="mvcPath" value="/edit_entry.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addEntryURL.toString() %>" value="Add Entry"></aui:button>
</aui:button-row>