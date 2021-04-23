package com.deepoove;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Measurement(iterations = 2, time = 6, timeUnit = TimeUnit.SECONDS)
@Threads(4)
@Fork(2)
@Warmup(iterations = 1)
@State(value = Scope.Benchmark)
public class ListBenchmark {

  @Param(value = { "10", "50", "100"})
  private int length;

  @Benchmark
  public void testListAdd(Blackhole blackhole) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < length; i++) {
      list.add(i);
    }
    blackhole.consume(list);
  }

  @Benchmark
  public void testListAddWithSize(Blackhole blackhole) {
    List<Integer> list = new ArrayList<Integer>(length);
    for (int i = 0; i < length; i++) {
      list.add(i);
    }
    blackhole.consume(list);
  }
}
