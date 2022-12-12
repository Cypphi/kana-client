package cypphi.amiss;

import java.util.ArrayList;

public class Setting {

    private final SettingType settingType;

    private final String name;

    private ArrayList<String> options;

    private String sval;
    private boolean bval;
    private double dval, min,max;

    private Object selected;

    public Setting(String name, String sval, ArrayList<String> options) {
        this.name = name;
        this.sval = sval;
        this.options = options;
        this.settingType = SettingType.COMBO;
    }

    public Setting(String name, int dval, double min, double max) {
        this.name = name;
        this.dval = dval;
        this.min = min;
        this.max = max;
        this.settingType = SettingType.SLIDER;
    }

    public Setting(String name, boolean bval) {
        this.name = name;
        this.bval = bval;
        this.settingType = SettingType.CHECK;
    }


    public String getName() {
        return name;
    }

    public String getSval() {
        return sval;
    }

    public void setSval(String sval) {
        this.sval = sval;
    }

    public ArrayList<String> getOptions(){
        return this.options;
    }

    public boolean getBval() {
        return bval;
    }

    public void setBval(boolean bval) {
        this.bval = bval;
    }

    public double getDval() {
        return this.dval;
    }

    public void setDval(double dval) {
        this.dval = dval;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public SettingType getSettingType() {
        return settingType;
    }
}

