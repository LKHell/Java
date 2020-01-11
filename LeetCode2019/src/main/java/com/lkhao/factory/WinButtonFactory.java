package com.lkhao.factory;

/**
 * describe:
 *
 * @author 李坤澔
 *     date 2020-01-08
 */
public class WinButtonFactory implements ButtonFactory {
    public AbstractButton createButton() {
        return new WinButton();
    }
}
