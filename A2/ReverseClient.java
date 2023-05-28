import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.io.*;

class ReverseClient{

    public static void main(String args[]){
        Reverse ReverseImpl = null;
        try{
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            String str = "";
            System.out.println("Enter String");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();

            String temp = ReverseImpl.reverse_string(str);

            System.out.println("Reversed String in Client: " + temp);
 
        }catch(Exception e){
            System.out.println("Exception " + e);
        }
    }
}
