#include <vector>
#include <algorithm>
#include <cstdlib>
#include <climits>
#include <cassert>
#include <cstdio>
#include <memory>
#include <chrono>

using namespace std;

struct Interval {
    int start;
    int end;
};

class BruteForceSolution {
public:
    BruteForceSolution(const vector<Interval>& intervals)
        : intervals_(intervals)
    {
    }
    vector<int> findIntervalIndices(int query) {
        vector<int> result;
        for (int i = 0; i < intervals_.size(); ++i) {
            if (intervals_[i].start <= query && query <= intervals_[i].end)
                result.push_back(i);
        }
        return result;
    }
private:
    vector<Interval> intervals_;
};

struct IntervalTreeNode {
    IntervalTreeNode(int s, int e)
        : start(s)
        , end(e)
    {
    }
    int start;
    int end;
    unique_ptr<IntervalTreeNode> left;
    unique_ptr<IntervalTreeNode> right;
    vector<int> coveredIndices;
};

class IntervalTreeSolution {
public:
    IntervalTreeSolution(const vector<Interval>& intervals)
    {
        int minStart = intervals[0].start,
            maxEnd = intervals[0].end;
        for (int i = 1; i < intervals.size(); ++i) {
            minStart = min(minStart, intervals[i].start);
            maxEnd = max(maxEnd, intervals[i].end);
        }
        root_.reset(new IntervalTreeNode(minStart, maxEnd));
        for (int i = 0; i < intervals.size(); ++i) {
            insert(root_.get(), intervals[i].start, intervals[i].end, i);
        }
    }
    vector<int> findIntervalIndices(int query) {
        vector<int> result;
        IntervalTreeNode* node = root_.get();
        while (node && node->start <= query && node->end >= query) {
            if (!node->coveredIndices.empty())
                result.insert(result.end(), node->coveredIndices.begin(), node->coveredIndices.end());
            int mid = node->start + (node->end - node->start) / 2;
            if (query <= mid)
                node = node->left.get();
            else
                node = node->right.get();
        }
        return result;
    }
private:
    void insert(IntervalTreeNode* node, int start, int end, int index) {
        if (node->start == start && node->end == end) {
            node->coveredIndices.push_back(index);
            return;
        }
        int mid = node->start + (node->end - node->start) / 2;
        if (start <= mid) {
            if (!node->left)
                node->left.reset(new IntervalTreeNode(node->start, mid));
            insert(node->left.get(), start, min(mid, end), index);
        }
        if (end > mid) {
            if (!node->right)
                node->right.reset(new IntervalTreeNode(mid + 1, node->end));
            insert(node->right.get(), max(mid + 1, start), end, index);
        }
    }
private:
    unique_ptr<IntervalTreeNode> root_;
};

vector<Interval> generateIntervals(int n, int limit) {
    vector<Interval> intervals(n);
    for (int i = 0; i < n; ++i) {
        intervals[i].start = rand() % limit;
        intervals[i].end = intervals[i].start + rand() % (limit - intervals[i].start);

        assert(intervals[i].start <= intervals[i].end);
    }
    return intervals;
}

vector<int> generateQueries(int n, int limit) {
    vector<int> queries(n);
    for (int i = 0; i < n; ++i)
        queries[i] = rand() % limit;
    return queries;
}

void printIntervals(const vector<Interval>& intervals) {
    for (const auto& interval : intervals) {
        printf("[%d, %d] ", interval.start, interval.end);
    }
    printf("\n");
}

void printVector(const vector<int>& arr) {
    for (int x : arr) {
        printf("%d ", x);
    }
    printf("\n");
}

const int N = 1000000;
const int Limit = INT_MAX;
const int Q = 10000000;

template<class TSolution>
int RunBenchmarkSolution(const vector<Interval>& intervals, const vector<int>& queries) {
    int result = 0;
    auto begin = chrono::steady_clock::now();
    TSolution solution(intervals);
    auto init = std::chrono::steady_clock::now();
    printf("    Init time, %ld\n", chrono::duration_cast<chrono::milliseconds>(init - begin).count());
    for (int q : queries) {
        result += solution.findIntervalIndices(q).size();
    }
    auto end = std::chrono::steady_clock::now();
    printf("    Solution time, %ld\n", chrono::duration_cast<chrono::milliseconds>(end - init).count());
    return result;
}

void RunBenchmark() {
    srand(12345);
    auto intervals = generateIntervals(N, Limit);
    auto queries = generateQueries(Q, Limit);
    printf("Brute force:\n");
    auto first = RunBenchmarkSolution<BruteForceSolution>(intervals, queries);
    printf("Interval tree:\n");
    auto second = RunBenchmarkSolution<IntervalTreeSolution>(intervals, queries);
    // verify interval tree solution is correct
    assert(first == second);
}

void RunCheck(int iterations = 100, int minSize = 100, int maxSize = 10000, int nQueries = 1000) {
    while (iterations--) {
        int n = minSize + rand() % (maxSize - minSize);
        auto intervals = generateIntervals(n, INT_MAX);
        auto queries = generateQueries(nQueries, INT_MAX);
        BruteForceSolution bfSolution(intervals);
        IntervalTreeSolution itSolution(intervals);
        for (int q : queries) {
            auto first = bfSolution.findIntervalIndices(q);
            auto second = itSolution.findIntervalIndices(q);
            sort(second.begin(), second.end());
            assert(first == second);
        }
    }
}

int main() {
    srand(time(nullptr));
    RunCheck();
    return 0;
}