package com.edteam1.smdb.transfer;

import lombok.Value;

@Value
public class KeyValue<K, V> {
	K key;
	V value;
}
