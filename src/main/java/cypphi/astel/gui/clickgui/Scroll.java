package cypphi.astel.gui.clickgui;

import cypphi.astel.gui.clickgui.element.ModuleButton;

import java.util.List;

public class Scroll {

    double scroll;
    int ymin, ymax;

    List<ModuleButton> moduleButtons;

    public Scroll(int ymin, int ymax, List<ModuleButton> moduleButtons) {
        this.ymin = ymin;
        this.ymax = ymax;
        this.moduleButtons = moduleButtons;
    }

    public boolean inBounds(double n, ModuleButton first, ModuleButton last) {
        if (!moduleButtons.isEmpty()) {
            return first.y-n <= ymin && last.y-n >= ymax;
        }
        else
            return false;
    }

    public double getScroll() {
        return scroll;
    }

    public void setScroll(double s) {
        double n = scroll-s;
        ModuleButton first = moduleButtons.get(0);
        ModuleButton last = moduleButtons.get(moduleButtons.toArray().length-1);
        if (inBounds(n, first, last)) scroll=scroll-s;
        else if (first.y - n > ymin) scroll = ymin;
        else if (last.y - n < ymax) scroll = ymax;
    }
}
