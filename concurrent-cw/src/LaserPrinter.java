public class LaserPrinter implements ServicePrinter {
    private final String name;
    private final int id;
    private int currentPaperLevel;
    private int currentTonerLevel;
    private int noOfDocumentsPrinted;
    private boolean paperRefilled = false;
    private boolean tonerReplaced = false;

    public boolean isPaperRefilled() {
        return paperRefilled;
    }

    public boolean isTonerReplaced() {
        return tonerReplaced;
    }

    public LaserPrinter(String name, int id, int currentPaperLevel, int currentTonerLevel, int noOfDocumentsPrinted) {
        this.name = name;
        this.id = id;
        this.currentPaperLevel = currentPaperLevel;
        this.currentTonerLevel = currentTonerLevel;
        this.noOfDocumentsPrinted = noOfDocumentsPrinted;
    }

    @Override
    public synchronized void printDocument(Document document) {
        while (!(document.getNumberOfPages() <= this.currentPaperLevel && document.getNumberOfPages() <= this.currentTonerLevel)) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.currentPaperLevel -= document.getNumberOfPages();
        this.currentTonerLevel -= document.getNumberOfPages();
        this.noOfDocumentsPrinted++;
        notifyAll();
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        boolean tried = false;
        this.tonerReplaced = false;

        while (this.currentTonerLevel > (Minimum_Toner_Level - 1)) {
            if (tried) {
                break;
            }
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tried = true;
        }
        if (this.currentTonerLevel < (Minimum_Toner_Level - 1)) {
            this.currentTonerLevel = 500;
            this.tonerReplaced = true;
        }
        notifyAll();
    }

    @Override
    public synchronized void refillPaper() {
        boolean tried = false;
        this.paperRefilled = false;

        while (!(this.currentPaperLevel <= (Full_Paper_Tray - 50))) {
            if (tried) {
                break;
            }
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tried = true;
        }
        if (this.currentPaperLevel <= (Full_Paper_Tray - 50)) {
            this.currentPaperLevel += 50;
            this.paperRefilled = true;
        }
        notifyAll();
    }

    @Override
    public String toString() {
        //[ Printer ID: lp-CG.24, Paper Level: 35, Toner Level: 310, Documents Printed: 4 ]
        return "[ " +
                "Printer ID: " + name + "." + id +
                ", Paper Level: " + currentPaperLevel +
                ", Toner Level: " + currentTonerLevel +
                ", No Of Documents Printed: " + noOfDocumentsPrinted +
                " ]";
    }
}
