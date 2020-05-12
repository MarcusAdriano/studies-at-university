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

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class R {

    final public static String PATH = "resources/";
    final public static String PATH_MINI_CARDS = "resources/cards/mini/";
    final public static String PATH_LARGE_CARDS = "resources/cards/large/";
    
    private static Font f = null;
    
    public synchronized static Font getFont() {
        if (f != null)
            return f;
        
        File font = new File(R.PATH + "font.ttf");
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, font);
        } catch (FontFormatException | IOException ex) {
            System.out.println("Font não encontrada!");
            System.exit(0);
        } 
        
        return f;
    }
}
