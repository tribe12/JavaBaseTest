package cn.wgh.enumTest;

import org.junit.Test;

public class EnumTest {
	@Test
	public void testName() throws Exception {
		System.out.println(EnumDomain.MAN);
		System.out.println(EnumDomain.MAN.name());
		
		System.out.println(AttachmentEnum.LEAVE);
		System.out.println(AttachmentEnum.SIGN_RECORD);
		System.out.println(AttachmentEnum.LEAVE.toString());
		System.out.println(AttachmentEnum.SIGN_RECORD.getValue());
		System.out.println(AttachmentEnum.SIGN_RECORD.getKey());
		System.out.println(AttachmentEnum.valueOf("LEAVE"));
		
		
	}
}
