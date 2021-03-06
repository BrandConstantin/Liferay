package com.liferay.docs.guestbook.portlet.portlet;

import com.liferay.docs.guestbook.portlet.constants.GuestbookPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Component;

/**
 * @author brand
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GuestbookPortletKeys.Guestbook,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GuestbookPortlet extends MVCPortlet {
	public void addEntry(ActionRequest request, ActionResponse response) {
	    try {
	        PortletPreferences prefs = request.getPreferences();

	        String[] guestbookEntries = prefs.getValues("guestbook-entries",
	                new String[1]);

	        ArrayList<String> entries = new ArrayList<String>();

	        if (guestbookEntries[0] != null) {
	            entries = new ArrayList<String>(Arrays.asList(prefs.getValues(
	                    "guestbook-entries", new String[1])));
	        }

	        String userName = ParamUtil.getString(request, "name");
	        String message = ParamUtil.getString(request, "message");
	        String entry = userName + "^" + message;

	        entries.add(entry);

	        String[] array = entries.toArray(new String[entries.size()]);

	        prefs.setValues("guestbook-entries", array);

	        try {
	            prefs.store();
	        }
	        catch (IOException ex) {
	            Logger.getLogger(GuestbookPortlet.class.getName()).log(
	                    Level.SEVERE, null, ex);
	        }
	        catch (ValidatorException ex) {
	            Logger.getLogger(GuestbookPortlet.class.getName()).log(
	                    Level.SEVERE, null, ex);
	        }

	    }
	    catch (ReadOnlyException ex) {
	        Logger.getLogger(GuestbookPortlet.class.getName()).log(
	                Level.SEVERE, null, ex);
	    }
	}
}