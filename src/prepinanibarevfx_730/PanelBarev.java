/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepinanibarevfx_730;

import javafx.scene.layout.FlowPane;
import utils.IObserver;

/**
 *
 * @author xzenj02
 */
public class PanelBarev extends FlowPane implements IObserver{
    
    private PrepinaniBarevFX prepinaniBarevFX;
    
    public PanelBarev(PrepinaniBarevFX prepinaniBarevFX){
        this.prepinaniBarevFX = prepinaniBarevFX;
        prepinaniBarevFX.registerObserver(this);
        init();
    }
    
    private void init(){
        this.setPrefHeight(100);
        update();
    }

    @Override
    public void update() {
        this.setStyle(prepinaniBarevFX.getStyl());
    }
    
}
