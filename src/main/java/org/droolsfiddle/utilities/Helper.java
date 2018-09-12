package org.droolsfiddle.utilities;

import org.droolsfiddle.utilities.WSLogger;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Iterator;

import org.drools.core.WorkingMemory;
import org.drools.core.spi.KnowledgeHelper;

import org.drools.core.spi.Salience;
import org.drools.core.base.SalienceInteger;

import org.drools.core.spi.Enabled;
import org.drools.core.base.EnabledBoolean;

public class Helper {
	
	private KnowledgeHelper drools;
	private WSLogger LOGGER;
	
	private static String format = " -- %s -- ";
	
	public Helper(WSLogger LOGGER){
		this.drools = null;
		this.LOGGER = LOGGER;
	}
	
	public Helper() {
	}
	
	public void setDrools(KnowledgeHelper drools) {
		this.drools = drools;
	}
	
    /**
     * log fact instance of the current workingMemory
     * 
     * @param KnowledgeHelper drools - just call 'drools' (DefaultKnowledgeHelper)
     * @param WSLogger LOGGER - just call 'LOGGER'
     */
	
	public static void showFacts(KnowledgeHelper drools, WSLogger LOGGER) {//KnowledgeHelper drools) {
		WorkingMemory wm = drools.getWorkingMemory();
	    Iterator<?> o = wm.iterateObjects();
	    int a = 0;
	    try {
			LOGGER.debug("Fact in the WorkingMemory : ");

		    while(o.hasNext()){
		    	a++;
		        LOGGER.debug(o.next().toString());
		    }
		    LOGGER.debug("---------- " + a +" Fact(s) --------------\n");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showFacts(WSLogger LOGGER, KnowledgeHelper drools) {
		showFacts(drools, LOGGER);
	}
	
	public void showFacts() {
		showFacts(drools, LOGGER);
	}
	
    /**
     * Set the enabled value of the current matched rule
     * 
     * @param KnowledgeHelper drools - just call 'drools' (DefaultKnowledgeHelper)
     * @param boolean enabled : new value
     * @return true : else the rule can't fire
     */
	
	public static boolean setEnabled(KnowledgeHelper drools, boolean enabled) {
		drools.getRule().setEnabled((Enabled) new EnabledBoolean(false));
		return true;
	}
	
	public boolean setEnabled(boolean enabled) {
		return setEnabled(drools, enabled);
	}
	
    /**
     * Set the salience of the current matched rule
     * Useless - Such that you cannot set the salience of a rule in Drools.
     * 
     * @param KnowledgeHelper drools - just call 'drools' (DefaultKnowledgeHelper)
     * @param int salience : new value
     * @return int oldSalience : preceding salience
     */
	
	public static int setSalience(KnowledgeHelper drools, int salience) {
		int oldSalience = drools.getRule().getSalienceValue();
		drools.getRule().setSalience((Salience)  new SalienceInteger(salience));
		return oldSalience;
	}
	
	public int setSalience(int salience) {
		return setSalience(drools, salience);
	}
	
	//** util print
	
    private static void print(Object object, WSLogger LOGGER) {
    	try {
    	LOGGER.debug(object.toString());
    	}
    	catch(NullPointerException | JsonProcessingException e) {
    		String error = "LOGGER Error";
    		print(error, LOGGER);
    	}
    }
	        
    public static void printStrings(ArrayList<String> t, String format, WSLogger LOGGER) {
    	for(String i : t) {
    		print(String.format(format, i), LOGGER);
    	}
    }
    
    public void printStrings(ArrayList<String> t, String format) {
    	printStrings(t, format, LOGGER);
    }
    
    public static void printStrings(String format, WSLogger LOGGER, String... strings) {
    	ArrayList<String> newT = new ArrayList<String>();
    	for(String s : strings)newT.add(s);
    	printStrings(newT, format, LOGGER);
    }
    
    public void printStrings(String format, String... strings) {
    	printStrings(format, LOGGER, strings);
    }
    
    public static void printStrings(String s, WSLogger LOGGER) {
    	printStrings(format, LOGGER, s);
    }
    
    public void printStrings(String s) {
    	printStrings(format, LOGGER, s);
    }
    
    public static void printStrings(WSLogger LOGGER, String...strings) {
    	printStrings(format,LOGGER, strings);
    }
    
    public void printStrings(String...strings) {
    	printStrings(format,LOGGER, strings);
    }
    
    public static void printStrings(WSLogger LOGGER, ArrayList<String> t) {
    	printStrings(t, format, LOGGER);
    }    

    public void printStrings(ArrayList<String> t) {
    	printStrings(t, format, LOGGER);
    }    
    
    public static void printStrings(ArrayList<String> t, WSLogger LOGGER) {
    	printStrings(LOGGER , t);
    }
    
    
    public static void printStrings(WSLogger LOGGER, String format, ArrayList<String> t) {
    	printStrings(t, format, LOGGER);
    }
    
    public void printStrings(String format, ArrayList<String> t) {
    	printStrings(t, format, LOGGER);
    }
    
    public static void printStrings(ArrayList<String> t, WSLogger LOGGER, String format) {
    	printStrings(t, format, LOGGER);
    }

    
    public static void printStrings(WSLogger LOGGER, ArrayList<String> t, String format) {
    	printStrings(t, format, LOGGER);
    }
    
    public static void printObjects(ArrayList<Object> o, WSLogger LOGGER, String format){
        ArrayList<String> t = new ArrayList<String>();
        for(Object m : o){
            t.add(m.toString());
        }
        
        printStrings(t, format, LOGGER);
    }
    
    public static void printObjects(WSLogger LOGGER, Object...objects) {
    	printObjects(format, LOGGER, objects);
    }
    
    public void printObjects(Object...objects) {
    	printObjects(format, LOGGER, objects);
    }
    
    public static void printObjects(Object o, WSLogger LOGGER) {
    	printStrings(LOGGER, o.toString());
    }
    
    public static void printObjects(String format, WSLogger LOGGER, Object...objects) {
    	ArrayList<Object> o = new ArrayList<Object>();
    	for(Object obj : objects)o.add(obj);
    	printObjects(o, LOGGER, format);
    }
    
    public static void printRule(KnowledgeHelper drools, WSLogger LOGGER) {
    	printObjects(LOGGER, drools.getRule());
    }
    
    public static void printRule(WSLogger LOGGER, KnowledgeHelper drools) {
    	printRule(drools, LOGGER);
    }
    
    
    public static void printMethods(WSLogger LOGGER, Object o) {
    	printObjects(LOGGER, (Object[]) o.getClass().getMethods());
    }
        
}
