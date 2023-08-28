import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter
{

    public static void main(String[] args)
    {
        File workingDirectory = new File(System.getProperty("user.dir"));
        String fileName = "";

        ArrayList<String> products = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);
//      a.	ID (a String as before in Person)
//      b.	Name (a String)
//      c.	Description (a String a short sentence)
//      d.	Cost (This is currency so it will be a Java double))
        //Declarations
        String productRecord = "";
        String iD = "";
        String name = "";
        String description = "";
        double cost = 0;

        do
        {
            iD = SafeInput.getNonZeroLenString(in, "Enter the ID number [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Enter the product name");
            description = SafeInput.getNonZeroLenString(in, "Enter the product description");
            cost = SafeInput.getRangedDouble(in, "Enter the product cost", 0, 99999);

            productRecord = iD + ", " + name + ", " + description + ", " + cost;

            products.add(productRecord);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }
        while(!done);
        fileName = SafeInput.getNonZeroLenString(in, "Enter what name do you want the new record file to have");
        Path file = Paths.get(workingDirectory.getPath() + "\\" + fileName + ".txt");

        for (String p: products)
            System.out.println(p);
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            for(String rec : products)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
