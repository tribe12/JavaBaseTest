package cn.wgh.hutoolTest;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;

import org.junit.Test;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.wgh.Class_Feflect.User;

public class HutoolAnnotationTest {
	@Test
	public void testName() throws Exception {
		Annotation[] annotations = AnnotationUtil.getAnnotations(User.class, true);
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}
}
