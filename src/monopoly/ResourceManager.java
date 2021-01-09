package monopoly;

import java.io.*;

public class ResourceManager {

    //serialization

    /**
     * save all data in board to monopoly.txt, including Square class, Player class and
     * Monster class which implements Serializable
     */
    public static void save(Serializable data,String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(data);
            out.close();
        } catch (IOException e) {
            System.out.println("File couldn't be save!");
        }
    }

    //deserialization

    /**
     * load the previous state player choose to save and continue game with the saved state
     */
    public static Board load(String fileName) {
        Board data=null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            data =(Board) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        } catch (IOException e) {
            System.out.println("Problem with loading the file ");
        }finally{
            System.out.println("Resume playing");
        }return data;
    }
}
