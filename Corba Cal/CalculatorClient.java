import CalculatorModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CosNaming.NamingContextExtPackage.*;

public class CalculatorClient {

	public static void main(String[] args) {
		try {
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "Calculator";
			Calculator implementation = CalculatorHelper.narrow(ncRef.resolve_str(name));
			System.out.println(implementation.add(1, 2));
			System.out.println(implementation.sub(1, 2));
			System.out.println(implementation.mul(1, 2));
			System.out.println(implementation.div(1, 2));									
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
