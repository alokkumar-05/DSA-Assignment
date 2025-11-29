class SegmentTreeSum {

    int[] tree;
    int[] arr;

    SegmentTreeSum(int[] arr) {
        this.arr = arr;
        tree = new int[arr.length * 4];
        build(0, 0, arr.length - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2 + 1, start, mid);
        build(node * 2 + 2, mid + 1, end);

        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    int querySum(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        int left = querySum(node * 2 + 1, start, mid, l, r);
        int right = querySum(node * 2 + 2, mid + 1, end, l, r);

        return left + right;
    }
}
