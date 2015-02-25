package no.ciber.ugly.struts;
import java.util.Vector;

/**
 * 
 * OPPGAVE 3: til opplysning så er 'issuing point' det samme som 'utstedelsespunkt' og 'application' er 'søknad'
 * 
 *
 */
public class StrutsActionKlasse {

	public Object mergeIssps(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) {
		IssuingPointForm ipform = (IssuingPointForm) form;
		int fromIssp = Integer.parseInt(ipform.getFromIssp());
		int toIssp = Integer.parseInt(ipform.getToIssp());
		MessageDAO msgdao = (MessageDAO) this.getWebApplicationContext().getBean("messagedaospring");
		ApplicationDAO appdao = (ApplicationDAO) this.getWebApplicationContext().getBean("applicationdaospringtoplink");
		IssuingPointDAO isspdao = (IssuingPointDAO) this.getWebApplicationContext().getBean("issuingpointdaospring");
		UserService userservice = (UserService) this.getWebApplicationContext().getBean("userservice");
		ApplicationService applicationService = (ApplicationService) getWebApplicationContext().getBean("applicationservice");

		// Start transaction.
		PlatformTransactionManager transManager = (PlatformTransactionManager) this.getWebApplicationContext().getBean("toplinkTransactionManager");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transManager.getTransaction(def);

		IssuingPoint from = isspdao.getIssuingPoint(fromIssp);
		IssuingPoint to = isspdao.getIssuingPoint(toIssp);

		Vector msgs = (Vector) msgdao.getMessages(from);
		int msgcnt = msgs.size();
		for (int i = 0; i < msgs.size(); i++) {
			Message msg = (Message) msgs.get(i);
			msg.getApplication().setRegisteredpoint(to);
		}
		// Get user from db based on the user in session so that the user is registered with toplink.
		User user = userservice.getUser(DIFAS.getLoggedinUser(req));

		Vector apps = (Vector) appdao.getApplications(from);
		int appcnt = apps.size();
		for (int i = 0; i < apps.size(); i++) {
			Application app = (Application) apps.get(i);
			app.setRegisteredpoint(to);

			Event event = new Event("SYSTEMEVENT", "Søknad flyttet fra " + from.getName() + " til " + to.getName() + ".", app, user);
			applicationService.addEvent(event);
		}

		transManager.commit(status);
		// End transaction

		req.setAttribute("msgcnt", Integer.toString(msgcnt));
		req.setAttribute("appcnt", Integer.toString(appcnt));
		req.setAttribute("fromIssp", from.getName());
		req.setAttribute("toIssp", to.getName());

		return mapping.findForward("isspmerged");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////IKKE SE PÅ KODEN UNDER HER ////////////////////////////////////
	
	private WebApplicationContext getWebApplicationContext() {
		// TODO Auto-generated method stub
		return new WebApplicationContext();
	}
	private class ActionMapping {
		public Object findForward(String string) {
			return null;
		}
	}
	private class ActionForm {}
	private class HttpServletRequest {
		public void setAttribute(String string, String string2) {}
	}
	private class HttpServletResponse {}
	private class IssuingPointForm extends ActionForm {
		public String getFromIssp() {
			return null;
		}
		public String getToIssp() {
	        return null;
        }
	}
	private class MessageDAO {
		public Vector getMessages(IssuingPoint from) {
			return null;
		}
	}
	private class ApplicationDAO {
		public Vector getApplications(IssuingPoint from) {
			return null;
		}
	}
	private class IssuingPointDAO {
		public IssuingPoint getIssuingPoint(int fromIssp) {
			return null;
		}
	}
	private class WebApplicationContext {
		public Object getBean(String navn) {
			return new Object();
		}
	}
	private class UserService {
		public User getUser(Object loggedinUser) {
			return null;
		}
	}
	private class ApplicationService {
		public void addEvent(Event event) {
		}
	}
	private class PlatformTransactionManager {
		public void commit(TransactionStatus status) {
		}
		public TransactionStatus getTransaction(DefaultTransactionDefinition def) {
			return null;
		}
	}
	private class TransactionStatus {
	}
	private class IssuingPoint {
		public String getName() {
			return null;
		}
	}
	private class User {
	}
	private class Event {
		public Event(String systemevent2, String string, Application app, User user) {
		}
	}
	private class Application {
		public void setRegisteredpoint(IssuingPoint to) {
		}
	}
	private static class DIFAS {
		public static Object getLoggedinUser(HttpServletRequest req) {
			return null;
		}
	}
	private class Message {
		public Application getApplication() {
			return new Application();
		}
	}
	private class DefaultTransactionDefinition {
		public void setPropagationBehavior(String propagationRequired) {
		}
	}
	private static class TransactionDefinition {
		public static final String PROPAGATION_REQUIRED = null;
	}
}
