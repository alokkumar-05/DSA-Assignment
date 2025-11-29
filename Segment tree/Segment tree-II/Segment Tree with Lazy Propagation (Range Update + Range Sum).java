class SegmentTreeLazy {

    int[] tree, lazy;

    SegmentTreeLazy(int n) {
        tree = new int[4 * n];
        lazy = new int[4 * n];
    }

    // Range Update
    void updateRange(int node, int start, int end, int l, int r, int val) {

        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (start > end || start > r || end < l) return;

        if (l <= start && end <= r) {
            tree[node] += (end - start + 1) * val;

            if (start != end) {
                lazy[node * 2 + 1] += val;
                lazy[node * 2 + 2] += val;
            }
            return;
        }

        int mid = (start + end) / 2;

        updateRange(node * 2 + 1, start, mid, l, r, val);
        updateRange(node * 2 + 2, mid + 1, end, l, r, val);

        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    // Range Query
    int queryRange(int node, int start, int end, int l, int r) {

        if (start > end || start > r || end < l) return 0;

        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        int left = queryRange(node * 2 + 1, start, mid, l, r);
        int right = queryRange(node * 2 + 2, mid + 1, end, l, r);

        return left + right;
    }
}
