package com.chess;

import com.chess.gui.Table;

import javax.swing.*;
import java.awt.*;

public class Leolix {

    public static void main(final String[] args) throws Exception {
        Table.get().show();
        ImageIcon icon = new ImageIcon("art/icon.png");
        if (Taskbar.isTaskbarSupported() && Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) {
            Taskbar.getTaskbar().setIconImage(icon.getImage());
        }
    }
}
