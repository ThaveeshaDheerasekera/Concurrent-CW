public class Student implements Runnable {
    private final String name;
    private final ThreadGroup group;
    private final Printer printer;

    public Student(String name, ThreadGroup group, Printer printer) {
        this.name = name;
        this.group = group;
        this.printer = printer;
    }

    @Override
    public void run() {
        Document []documents = new Document[5];
        documents[0] = new Document("Doc001", "6SENG006C_CW", 5);
        documents[1] = new Document("Doc002", "6COSC023C_CW1_PP", 7);
        documents[2] = new Document("Doc003", "6COSC023C_CW2_PSPD", 10);
        documents[3] = new Document("Doc004", "6SENG005C_CW", 4);
        documents[4] = new Document("Doc005", "Final_Project_Draft", 7);

        int noOfPages = 0;
        for (Document doc: documents) {
            printer.printDocument(doc);
            noOfPages += doc.getNumberOfPages();
        }
        int num = ((int)(Math.random() * 100 +1));
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " Finished Printing 5 Documents. " + noOfPages + " pages.");
    }
}
