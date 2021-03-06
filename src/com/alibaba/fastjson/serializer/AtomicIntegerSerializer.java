package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSerializer
  implements ObjectSerializer
{
  public static final AtomicIntegerSerializer instance = new AtomicIntegerSerializer();

  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramJSONSerializer.getWriter().writeInt(((AtomicInteger)paramObject1).get());
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.AtomicIntegerSerializer
 * JD-Core Version:    0.6.2
 */