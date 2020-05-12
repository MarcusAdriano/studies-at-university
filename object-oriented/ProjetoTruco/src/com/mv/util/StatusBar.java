/*
 * /* Copyright 2016 Marcus Adriano, Vitor Hugo
 * *
 * *   Licensed under the Apache License, Version 2.0 (the "License");
 * *   you may not use this file except in compliance with the License.
 * *   You may obtain a copy of the License at
 *
 * *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * *   Unless required by applicable law or agreed to in writing, software
 * *   distributed under the License is distributed on an "AS IS" BASIS,
 * *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * *   See the License for the specific language governing permissions and
 * *   limitations under the License.
 */
package com.mv.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class StatusBar extends javax.swing.JPanel implements Serializable{
    
    private Container mRootPane;
    private JLabel mLabel;
    private int timeToClear;
    private boolean cleanable;
    private Thread t;
    private boolean isError;
    
    public StatusBar (Container rootPane) {
        mRootPane = rootPane;   
        mLabel = new JLabel();
        cleanable = false;
        timeToClear = 5 * 1000;
        
        super.setPreferredSize(new Dimension(mRootPane.getWidth(), 23));
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        super.setBorder(BorderFactory.createLoweredBevelBorder());
        
        super.add(Box.createHorizontalStrut(15));
        super.add(mLabel);
    }    
    
    public void setMensagem(String message) {
        if (!isError) mLabel.setForeground(Color.black);
        mLabel.setText(message);
        
        if (!cleanable) return;
        
        Runnable clearInBackground = () -> {
            try {
                Thread.sleep(timeToClear);
                mLabel.setText("");
                t = null;
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());

            }
        };
        
        if (t != null) {
            t.interrupt();
            t = null;
        }
        
        t = new Thread(clearInBackground);
        t.start();
    }
    
    public void setError(String mensagem) {
        mLabel.setForeground(Color.red);
        isError = !isError;
        setMensagem(mensagem);
        isError = !isError;
    }
    
    @Override
    public void add(Component comp, Object constraints, int index) {
        
    }

    @Override
    public void add(Component comp, Object constraints) {
        
    }

    @Override
    public Component add(Component comp, int index) {
        return null; 
    }

    @Override
    public Component add(String name, Component comp) {
        return null;  
    }

    @Override
    public Component add(Component comp) {
        return null;
    }   
    
    public int getTimeToClear() {
        return timeToClear;
    }
    
    public void setTimeToClear(int timeInSeconds) {
        if (timeInSeconds < 0 || timeInSeconds > 10) return;
        timeToClear = timeInSeconds * 1000;
    }

    public boolean isCleanable() {
        return cleanable;
    }

    public void setCleanable(boolean cleanable) {
        if (t != null) {
            t.interrupt();
            t = null;
        }
        this.cleanable = cleanable;
    }
    
    public void clear() {
        mLabel.setText("");
    }
}
