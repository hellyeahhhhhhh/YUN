package com.kumakitty.yun;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.kumakitty.adapter.ItemAdapter;
import com.rockerhieu.rvadapter.endless.EndlessRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EndlessRecyclerViewAdapter.RequestToLoadMoreListener {


    String[] urls = {"http://7xuh3d.com1.z0.glb.clouddn.com/Character%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2004.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2005.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2006.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2007.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2008.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2011.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2012.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2013.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2014.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Character%2015.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2003.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2004.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2005.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2006.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2007.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2008.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2009.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2010.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2011.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2012.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2013.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2014.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2015.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2016.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2018.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2019.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2020.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2021.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2022.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Environment%2023.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2003.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2004.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2005.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2006.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2007.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2008.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2009.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2010.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2011.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2012.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2013.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2014.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2016.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2017.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2018.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2019.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2020.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2021.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2022.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2023.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2024.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2025.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2026.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2027.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2028.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2029.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2030.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2031.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2032.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2033.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2034.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshot%2035.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2003.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2004.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2005.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2006.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2007.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2008.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2009.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2010.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2011.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2012.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2013.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2014.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2015.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2016.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2017.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2018.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2019.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2020.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2021.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2022.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2023.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2024.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2025.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2026.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2027.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2028.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2029.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2030.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2031.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2032.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2033.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2034.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2035.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2036.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2037.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2038.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2039.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2040.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2041.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2042.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2043.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2044.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2045.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2046.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2047.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2048.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2049.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2050.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2051.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2052.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2053.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2054.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2055.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2056.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2057.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2058.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2059.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2060.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2061.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2062.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2063.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2064.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2065.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2066.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2067.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2068.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2069.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2070.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2071.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2072.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2073.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2074.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2075.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2076.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2077.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2078.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2079.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2080.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2081.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2082.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2083.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2084.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2085.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2086.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2087.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2088.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2089.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2090.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2091.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2092.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2093.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2094.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2095.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2096.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2097.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2098.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%2099.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20100.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20101.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20102.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20103.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20104.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20105.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20106.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20107.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20108.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20109.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20110.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20111.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20112.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20113.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20114.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20115.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20116.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20117.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20118.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20119.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20120.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20121.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20122.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20123.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20124.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20125.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20126.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20127.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20128.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20129.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20130.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20131.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20132.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20133.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20134.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Journey%20Screenshotplay%20135.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Machine%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Machine%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Machine%2003.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2001.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2002.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2003.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2004.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2005.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2006.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2007.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2008.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Miscellaneous%2009.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Mountains%20HD.jpg",
            "http://7xuh3d.com1.z0.glb.clouddn.com/Mountains%20SD.jpg"};
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EndlessRecyclerViewAdapter elAdapter;
    ItemAdapter mAdapter;
    ArrayList<String> url = new ArrayList<>();
    ArrayList<String> addurl = new ArrayList<>();
    public static int location = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUrls(urls);
        mAdapter = new ItemAdapter(url, this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter.setOnItemClickListener(new ItemAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Intent intent = new Intent(MainActivity.this, ImageShow.class);
                intent.putExtra("url", data);
                startActivity(intent);
            }
        });
        initView();
    }

    private void initUrls(String[] urls) {
        for (int i = 0; i < 15; i++) {
            url.add(urls[i]);
        }

    }

    private void addUrls(String[] urls, int location) {
        addurl.clear();
        for (int i = 0; i < 5; i++) {
            addurl.add(urls[location + i]);
        }

    }

    void initView() {
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        elAdapter = new EndlessRecyclerViewAdapter(this, mAdapter, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(elAdapter);
    }

    @Override
    public void onLoadMoreRequested() {
        new AsyncTask<Void, Void, ArrayList>() {
            @Override
            protected ArrayList doInBackground(Void... params) {
                location += 5;
                if (location < urls.length) {
                    addUrls(urls, location);
                } else {
                    addUrls(urls, urls.length - location + 5);
                    location = 0;
                }
                return addurl;
            }

            @Override
            protected void onPostExecute(ArrayList list) {
                mAdapter.appendItems(list);
                elAdapter.onDataReady(true);
            }
        }.execute();
    }
}
