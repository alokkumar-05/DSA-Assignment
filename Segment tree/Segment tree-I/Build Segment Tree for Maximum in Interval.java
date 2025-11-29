class SegmentTreeMax {

    int[] tree;
    int[] arr;

    SegmentTreeMax(int[] arr) {
        this.arr = arr;
        tree = new int[arr.length * 4];
        build(0, 0, arr.length - 1);
    }

    // Build Tree
    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2 + 1, start, mid);
        build(node * 2 + 2, mid + 1, end);

        tree[node] = Math.max(tree[node * 2 + 1], tree[node * 2 + 2]);
    }

    // Query max
    int queryMax(int node, int start, int end, int l, int r) {
        // no overlap
        if (r < start || end < l) return Integer.MIN_VALUE;

        // complete overlap
        if (l <= start && end <= r) return tree[node];

        // partial overlap
        int mid = (start + end) / 2;
        int left = queryMax(node * 2 + 1, start, mid, l, r);
        int right = queryMax(node * 2 + 2, mid + 1, end, l, r);

        return Math.max(left, right);
    }
}
