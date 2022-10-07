class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        unordered_map<int, int> doubled;
        vector<int> res;
        sort(changed.rbegin(), changed.rend());
        for (int c : changed) {
            if (doubled[c * 2] > 0) {
                res.push_back(c);
                doubled[c * 2]--;
            } else {                
                doubled[c] ++;
            }
        }
        int sz = changed.size();
        if (sz % 2 == 1) {
            sz++;
        }
        return res.size() == (sz / 2) ? res : vector<int>();
    }
};