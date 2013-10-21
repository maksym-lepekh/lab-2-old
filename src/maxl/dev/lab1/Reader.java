package maxl.dev.lab1;

import java.io.*;

/**
 * Created by Максим on 22.10.13.
 */
public class Reader {
    public int userNum;
    public int connectionsNum;
    public int connections[][];
    public int votingNum;
    public int voting[][];

    private String inputFileName;

    public Reader(String inputFileName)
    {
        this.inputFileName = inputFileName;
    }

    public void read() throws IOException
    {
        DataInputStream is = new DataInputStream(new FileInputStream(this.inputFileName));

        userNum = is.readInt();
        connectionsNum = is.readInt();
        connections = new int[connectionsNum][2];
        for (int i = 0; i < connectionsNum; i++)
        {
            connections[i][0] = is.readInt();
            connections[i][1] = is.readInt();
        }

        votingNum = is.readInt();
        voting = new int[votingNum][2];
        for (int i = 0; i < votingNum; i++)
        {
            voting[i][0] = is.readInt();
            voting[i][1] = is.readInt();
        }

    }
}
