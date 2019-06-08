//package cn.wgh.music;
//
//import java.beans.Encoder;
//import java.io.File;
//import it.sauronsoftware.jave.AudioAttributes;
//import it.sauronsoftware.jave.Encoder;
//import it.sauronsoftware.jave.EncoderException;
//import it.sauronsoftware.jave.EncodingAttributes;
//import it.sauronsoftware.jave.InputFormatException;
//
//
//
//
//import org.junit.Test;
//
//public class amrTest {
//	@Test
//	public void testName() throws Exception {
//		File source = new File("E:\\gtGEHFWPLYxlsJmjaMJJYwuvvQxh6qHcZxzV-FuvCtkWM9XFimee0L2Zi9sCepqS.amr");
//		File target = new File("D:\\1381370093615.mp3");
//		AudioAttributes audio = new AudioAttributes();
//		Encoder encoder = new Encoder();
//
//
//		audio.setCodec("libmp3lame");
//		EncodingAttributes attrs = new EncodingAttributes();
//		attrs.setFormat("mp3");
//		attrs.setAudioAttributes(audio);
//
//		try {
//		encoder.encode(source, target, attrs);
//		} catch (IllegalArgumentException e) {
//		e.printStackTrace();
//		} catch (InputFormatException e) {
//		e.printStackTrace();
//		} catch (EncoderException e) {
//		e.printStackTrace();
//		}
//	}
//}
