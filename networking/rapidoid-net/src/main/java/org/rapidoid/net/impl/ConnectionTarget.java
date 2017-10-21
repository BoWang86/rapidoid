package org.rapidoid.net.impl;

/*
 * #%L
 * rapidoid-net
 * %%
 * Copyright (C) 2014 - 2017 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.rapidoid.RapidoidThing;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.net.Protocol;
import org.rapidoid.u.U;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

@Authors("Nikolche Mihajlovski")
@Since("NET_EXTRAS")
public class ConnectionTarget extends RapidoidThing {

	volatile SocketChannel socketChannel;

	final InetSocketAddress addr;

	volatile long retryAfter;

	final Protocol protocol;

	final ChannelHolderImpl holder;

	final boolean autoreconnecting;

	final ConnState state;

	public ConnectionTarget(SocketChannel socketChannel, InetSocketAddress addr, Protocol protocol,
	                        ChannelHolderImpl holder, boolean autoreconnecting, ConnState state) {

		U.notNull(protocol, "connection protocol");
		U.notNull(holder, "connection holder");

		this.socketChannel = socketChannel;
		this.addr = addr;
		this.protocol = protocol;
		this.retryAfter = U.time();
		this.holder = holder;
		this.autoreconnecting = autoreconnecting;
		this.state = state;
	}

}
