package maxl.dev.lab1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Максим on 22.10.13.
 */
public class Generator {
    public static void main (String args[]){
        File f = new File("lab2.dat");
        try {
            if (f.exists())
                f.delete();
            f.createNewFile();

            DataOutputStream os = new DataOutputStream(new FileOutputStream("lab2.dat"));
            Random rand = new Random(System.currentTimeMillis());

            int userNumber = rand.nextInt(100);
            os.writeInt(userNumber);
            int connections = rand.nextInt(1000);
            os.writeInt(connections);

            for (int i = 0; i < connections; i++)
            {
                os.writeInt(rand.nextInt(userNumber));
                os.writeInt(rand.nextInt(userNumber));
            }

            int votingNumber = rand.nextInt(1000);
            os.writeInt(votingNumber);

            for (int i = 0; i < votingNumber; i++)
            {
                os.writeInt(rand.nextInt(userNumber));
                os.writeInt(rand.nextInt(8) + 1);
            }

            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
