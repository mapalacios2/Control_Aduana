/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Pancho
 */
@ManagedBean
@ViewScoped
public class GaleriaBean {

    private List<String> images;

    @PostConstruct
    public void init() {

        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("adu" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}
