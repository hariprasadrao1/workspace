package com.example.graph;

import android.content.Context;
import android.opengl.GLSurfaceView;


	class MyGLSurfaceView extends GLSurfaceView {

	    public MyGLSurfaceView(Context context){
	        super(context);
	        setEGLContextClientVersion(2);
	        // Set the Renderer for drawing on the GLSurfaceView
	        setRenderer( new MyGL20Renderer());
	        
	    }
	}

