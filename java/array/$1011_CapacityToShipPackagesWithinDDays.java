package array;


class $1011_CapacityToShipPackagesWithinDDays {
    /**
     * 由题意可知，最低运载能力一定大于最重包裹重量和平均包裹重量
     * 所以我们可以先求出这个最重包裹重量和平均包裹重量的最大值max_weight，
     * 然后从第一个元素开始累加，如果[i,j]之和加上j+1大于max_weight，则表示[i,j]之和为一天最多能运送的包裹量，
     * 累积天数countDay，从[j+1...]重新开始累加，表示开始第二天运送包裹，直至所有的包裹运送完毕
     * 比较累积天数countDay和目标天数D，如果countDay > D，则表示运载能力太低，max_weight++，重复上述的累加过程，直至countDay <= D
     */
    public int shipWithinDays1(int[] weights, int D) {
        int max_weight = 0, sum_weight = 0;
        for (int weight : weights) {
            sum_weight += weight;
            max_weight = Math.max(max_weight, weight);
        }
        //得到最重包裹重量和平均包裹重量的最大值
        max_weight = Math.max(sum_weight % D == 0 ? sum_weight / D : sum_weight / D + 1, max_weight);

        while (true) {
            int countDay = 1, countWeight = 0;
            //进行累积
            for (int weight : weights) {
                //比较是否超过限定值
                if (countWeight + weight > max_weight) {
                    //天数+1，开始累积[j+1]之后的元素
                    countDay++;
                    countWeight = weight;
                } else {
                    countWeight += weight;
                }
            }

            if (countDay <= D) {
                return max_weight;
            } else {
                //调整限定值，再次计算
                max_weight++;
            }

        }
    }

    /**
     * 第一种方法比较暴力，我们可以优化一下，使用二分法
     * 考虑两种极端情况，当最低运载能力为包裹最大重量时，每天需要一条船来运输，D为nums.length
     * 当最低运载能力为包裹总重量时，只需要一条船就可以运完，D为1
     * 所以最低运载能力一定位于[max(weight),sum(weight)]之间，
     * 设定最低运载能力为中间值，使用与第一种方法相同的方式累加天数，如果countDay > D，表示运载能力太小，lo = mid+1
     * 如果countDay <= D,表示运载能力太大，hi = mid;
     * 直至两指针相遇
     */
    public int shipWithinDays2(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            //求出最大包裹重量
            left = Math.max(left, weight);
            //求出总重量
            right += weight;
        }

        while (left < right) {
            //设定限定值
            int mid = left + (right - left) / 2;
            int countDay = 1, countWeight = 0;
            //进行累积
            for (int weight : weights) {
                //比较是否超过限定值
                if (countWeight + weight > mid) {
                    //天数+1，开始累积[j+1]之后的元素
                    countDay++;
                    countWeight = weight;
                } else {
                    countWeight += weight;
                }
            }

            if (countDay > D) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }
}
