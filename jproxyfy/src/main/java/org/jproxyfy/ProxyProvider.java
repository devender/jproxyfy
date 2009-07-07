package org.jproxyfy;

import org.jproxyfy.tree.RequestTree;

public interface ProxyProvider {
	void fullfillRequests(RequestTree requestTree);
}
