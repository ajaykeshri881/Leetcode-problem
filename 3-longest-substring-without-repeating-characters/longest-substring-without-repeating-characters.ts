function lengthOfLongestSubstring(s: string): number {
  let left = 0;
  let maxLength = 0;

  const map: Record<string, number> = {};

  for (let right = 0; right < s.length; right++) {
    const char = s[right];

    if (map[char] !== undefined && map[char] >= left) {
      left = map[char] + 1;
    }

    map[char] = right;

    maxLength = Math.max(maxLength, right - left + 1);
  }

  return maxLength;
}