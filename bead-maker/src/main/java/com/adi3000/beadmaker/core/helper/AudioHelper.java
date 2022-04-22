package com.adi3000.beadmaker.core.helper;

import javax.sound.sampled.*;
import java.io.File;

public class AudioHelper {
	
	//https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
	public static void PlayAudioFile(File file)
	{
		try
		{
			final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));

			clip.addLineListener(new LineListener()
			{
				@Override
				public void update(LineEvent event)
				{
					if (event.getType() == LineEvent.Type.STOP)
						clip.close();
				}
			});

			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(System.out);
		}
	}
}
