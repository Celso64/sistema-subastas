package com.subasta.ui.share.util;

import javax.swing.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class FindIcon {

    private static final String URL_BASE = "/icons/";
    private static final Map<Icon, String> ICONOS_URL = Map.of(
            Icon.APP, "icono.png",
            Icon.ATRAS, "atras.png",
            Icon.GUARDAR, "guardar.png",
            Icon.CARTAS, "cartas.png",
            Icon.COMPRADOR, "comprador.png"
    );

    private static final Map<Icon, ImageIcon> ICONOS_CACHE = new HashMap<>();

    public static Optional<ImageIcon> getIcon(Icon icon){
        var res = findInCache(icon);
        if (res.isPresent()) return res;
        return findInSystemFile(icon);
    }

    private static Optional<ImageIcon> findInCache(Icon icon){
        var res = ICONOS_CACHE.get(icon);
        return Objects.nonNull(res) ?
                Optional.of(res) :
                Optional.empty();
    }

    private static Optional<ImageIcon> findInSystemFile(Icon icon){
        String object = ICONOS_URL.getOrDefault(icon, "");

        if (!object.isEmpty()){
            URL url = FindIcon.class.getResource(URL_BASE+object);
            if(Objects.nonNull(url)) {
                var img = new ImageIcon(url);
                ICONOS_CACHE.put(icon, img);
                return Optional.of(img);
            }
        }
        return Optional.empty();
    }
}
