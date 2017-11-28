/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepinanibarevfx_730;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import utils.IObserver;

/**
 *
 * @author xzenj02
 */
public class ListBarev extends ListView implements IObserver {

    private ObservableList<String> barvyData;
    private PrepinaniBarevFX prepinaniBarevFX;
    
    public ListBarev(PrepinaniBarevFX prepinaniBarevFX){
        this.prepinaniBarevFX = prepinaniBarevFX;
        prepinaniBarevFX.registerObserver(this);
        init();
    }
    
    private void init(){
        barvyData =  FXCollections.observableArrayList();
        this.setItems(barvyData);
        this.setPrefWidth(100);
        update();
    }
    
    @Override
    public void update() {
        barvyData.add(prepinaniBarevFX.getBarva());
    }
    
}
