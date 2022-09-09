package FrameHome;

import javax.swing.JPanel;

public class MasterMain extends JPanel{
    
    private boolean logicalGrafo[][];
    
    public MasterMain(boolean logicalGrafoIn[][]){
        setLogicalGrafo(logicalGrafoIn);
    }
    
    public void setLogicalGrafo(boolean  in[][]){
        this.logicalGrafo = in;
    }
    
    public boolean[][] getLogicalGrafo(){
        return this.logicalGrafo;
    }
    
}
