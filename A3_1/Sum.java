import java.util.*;
import mpi.MPI;

class Sum{
    public static void main(String args[]){
        MPI.Init(args);
        int n = 6;
        int me = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int per_process = n / size;
        int root = 0;
        int result = 0;
        
        int[] send_buffer = {1, 2, 3, 4, 5, 6};
        int[] receive_buffer = new int[per_process];
        int[] ans = new int[size];
        int[] partial_sum = new int[1];

        MPI.COMM_WORLD.Scatter(send_buffer, 0, per_process, MPI.INT, receive_buffer, 0, per_process, MPI.INT, root);

        partial_sum[0] = 0;
        for(int i = 0; i < per_process; i++){
            partial_sum[0] += receive_buffer[i];
        }
        System.out.println("Process " + me + " has data " + Arrays.toString(receive_buffer) + " and partial sum " + partial_sum[0]);

        MPI.COMM_WORLD.Gather(partial_sum, 0, 1, MPI.INT, ans, 0, 1, MPI.INT, root);


        if(me == 0){
            for(int i = 0; i < size; i++){
                result += ans[i];
            }
            System.out.println("Total Sum for array " + Arrays.toString(send_buffer) + " is " + result);
        }
        
        MPI.Finalize();
    }
}