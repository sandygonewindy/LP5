import CalculatorModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CosNaming.NamingContextExtPackage.*;
import org.omg.PortableServer.*;

public class CalculatorServer {

	public static void main(String[] args) {
		try {
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			System.out.println("POA Initialized");
			//	Initialize Naming Context reference
			NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			System.out.println("Name Service Initialized");			
			CalculatorImplementation c = new CalculatorImplementation();
			System.out.println("Implementation object Initialized");
			org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(c);
			System.out.println("Object reference for implement generated through POA");
			Calculator h_ref = CalculatorHelper.narrow(objRef);
			System.out.println("Calculator object created by helper");
			String name = "Calculator";
			NameComponent[] path = ncRef.to_name(name);
			ncRef.rebind(path, h_ref);
			System.out.println("Name bound to reference using naming service");
			orb.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
