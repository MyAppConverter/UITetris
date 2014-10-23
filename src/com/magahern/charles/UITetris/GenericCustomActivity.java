/*
 * Copyright (c) 2014 MyAppConverter
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MyAppConverter License v1.0
 * which accompanies this distribution, and is available at
 * http://www.myappconverter.com/legal/epl-v1.html
 *
 * Contributors:
 *    MyAppConverter Core Team - initial API and implementation
 * @date : Sep, 18 2014 - 11:03:46
 */

package com.magahern.charles.UITetris;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetrisViewController;
import com.myappconverter.java.uikit.UIWindow;
import com.myappconverter.mapping.utils.GenericMainContext;

public class GenericCustomActivity extends Activity {

	RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GenericMainContext.MAIN_CONTEXT_ACTIVITY = this;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		UITetrisViewController tgVC = (UITetrisViewController) new UITetrisViewController()
				.init();
		tgVC.viewDidLoad();
		UIWindow window = new UIWindow();
		window.setRootViewController(tgVC);
		tgVC.getWrappedActivity().setRequestedOrientation(
				ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(tgVC.view().getWrappedView());
	}

}
