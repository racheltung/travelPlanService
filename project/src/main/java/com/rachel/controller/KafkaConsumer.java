package com.rachel.controller;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class KafkaConsumer implements Runnable {
	private KafkaStream m_stream;
	private int m_threadNumber;

	public KafkaConsumer(KafkaStream m_stream, int m_threadNumber) {
		super();
		this.m_stream = m_stream;
		this.m_threadNumber = m_threadNumber;
	}

	@Override
	public void run() {
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (it.hasNext())
			System.out.println("Thread " + m_threadNumber + ": " + new String(it.next().message()));
		System.out.println("Shutting down Thread: " + m_threadNumber);
	}

}
