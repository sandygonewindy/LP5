import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class ReverseServer{
    public static void main(String args[]){
        try{
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            ReverseImpl rvr = new ReverseImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
            Reverse h_ref = ReverseHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);
            System.out.println("Server waiting");

            orb.run();

        }catch(Exception e){
            System.out.println("Exception " + e);
        }
    }
}
