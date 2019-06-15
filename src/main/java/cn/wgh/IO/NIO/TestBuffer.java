package cn.wgh.IO.NIO;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class TestBuffer {
    
    public static void main(String[] args) throws Exception{
        
        FileInputStream fin = new FileInputStream("F:\\javatest\\NIOTest\\test.txt"); 
        FileChannel fc = fin.getChannel();
        
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化",buffer);
        
        fc.read(buffer);
        output("调用read()", buffer);

        buffer.flip();
        output("调用flip()", buffer);

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            // System.out.print(((char)b));
        }
        output("调用get()", buffer);

        buffer.clear();
        output("调用clear()", buffer);

        fin.close();

    }
    
    public static void output(String step, Buffer buffer) {
        System.out.println(step + " : ");
        System.out.print("capacity: " + buffer.capacity() + ", ");
        System.out.print("position: " + buffer.position() + ", ");
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }
    
    
    /**
     * 缓冲区分片
     * 只有子缓冲区“可见的”那部分数据发生了变化，并且说明子缓冲区与原缓冲区是数据共享的
     */
    @Test
    public void testSliceBuffer(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        
        // 缓冲区中的数据0-9
        for (int i=0; i<buffer.capacity(); i++) {
            buffer.put( (byte)i );
        }
        
        // 创建子缓冲区
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();
        
        // 改变子缓冲区的内容
        for (int i=0; i<slice.capacity(); i++) {
            byte b = slice.get( i );
            b *= 10;
            slice.put( i, b );
        }
        
        buffer.position( 0 );
        buffer.limit( buffer.capacity() );
        
        while (buffer.remaining()>0) {
            System.out.println( buffer.get() );
        }
        System.out.print("\n");
    }
    
    
    /**
     * 只读缓冲区
     * 只读缓冲区，这个方法返回一个与原缓冲区完全相同的缓冲区，并与原缓冲区共享数据，只不过它是只读的。
     * 如果原缓冲区的内容发生了变化，只读缓冲区的内容也随之发生变化：
     */
    @Test
    public void testReadOnlyBuffer(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
        
        // 缓冲区中的数据0-9
		for (int i = 0; i < buffer.capacity(); ++i) {
			buffer.put((byte) i);
		}

        // 创建只读缓冲区
        ByteBuffer readonly = buffer.asReadOnlyBuffer();
        
        // 改变原缓冲区的内容
        for (int i=0; i<buffer.capacity(); ++i) {
            byte b = buffer.get( i );
            b *= 10;
            buffer.put( i, b );
        }
        
        readonly.position(0);
        readonly.limit(buffer.capacity());
        
        // 只读缓冲区的内容也随之改变
        while (readonly.remaining()>0) {
            System.out.println( readonly.get());
        }
    }


}