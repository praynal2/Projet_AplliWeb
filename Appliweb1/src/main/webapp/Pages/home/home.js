document.addEventListener('click', e => {
    const isDropdownButton = e.target.matches("[data-dropdown-button], [data-dropdown-button] *")
    if (!isDropdownButton && e.target.closest("[data-dropdown]") != null ) return

    let currentDropdown
    if (isDropdownButton) {
        currentDropdown = e.target.closest("[data-dropdown]")
        currentDropdown.classList.toggle("active")
    }

    document.querySelectorAll("[data-dropdown].active").forEach(dropdown => {
        if (dropdown === currentDropdown) return 
        dropdown.classList.remove("active")    
    })
})


const music = new Audio('../../Songs/1.mp3');

const songs = [
    {
        id:'1',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image1.jpg',
        isFavorite: false,
    },
    {
        id:'2',
        songName:`Pluie hivernale<br><div class="subtitle"> Old school</div>`,
        poster: '../../images/image2.jpg',
        isFavorite: false,
    },
    {
        id:'3',
        songName:`Lavande <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image3.jpg',
        isFavorite: false,
    },
    {
        id:'4',
        songName:`Lmpl <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image4.jpg',
        isFavorite: false,
    },
    {
        id:'5',
        songName:`Sunlight <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image5.jpg',
        isFavorite: false,
    },
    {
        id:'6',
        songName:`Terrain <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image6.jpg',
        isFavorite: false,
    },
    {
        id:'7',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image7.jpg',
        isFavorite: false,
    },
    {
        id:'8',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image8.jpg',
        isFavorite: false,
    },
    {
        id:'9',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image9.jpg',
        isFavorite: false,
    },
    {
        id:'10',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image10.jpg',
        isFavorite: false,
    },
    {
        id:'11',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image11.jpg',
        isFavorite: false,
    },
    {
        id:'12',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image12.jpg',
        isFavorite: false,
    },
    {
        id:'13',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image13.jpg',
        isFavorite: false,
    },
    {
        id:'14',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image14.jpg',
        isFavorite: false,
    },
    {
        id:'15',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image15.jpg',
        isFavorite: false,
    },
    {
        id:'16',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image16.jpg',
        isFavorite: false,
    },
    {
        id:'17',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image17.jpg',
        isFavorite: false,
    },
    {
        id:'18',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image18.jpg',
        isFavorite: false,
    },
    {
        id:'19',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image19.jpg',
        isFavorite: false,
    },
    {
        id:'20',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image20.jpg',
        isFavorite: false,
    },
    {
        id:'21',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image21.jpg',
        isFavorite: false,
    },
    {
        id:'22',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image22.jpg',
        isFavorite: false,
    },
    {
        id:'23',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image23.jpg',
        isFavorite: false,
    },
    {
        id:'24',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image24.jpg',
        isFavorite: false,
    },
    {
        id:'25',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image25.jpg',
        isFavorite: false,
    },
    {
        id:'26',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image26.jpg',
        isFavorite: false,
    },
    {
        id:'27',
        songName:`Entrance <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image27.jpg',
        isFavorite: false,
    },
    {
        id:'28',
        songName:`Entrance 2 <br><div class="subtitle"> Trap</div>`,
        poster: '../../images/image28.jpg',
        isFavorite: false,
    },
    {
        id:'29',
        songName:`Salut <br><div class="subtitle"> Pop</div>`,
        poster: '../../images/image29.jpg',
        isFavorite: false,
    },
    {
        id:'30',
        songName:`Yo <br><div class="subtitle"> Drill</div>`,
        poster: '../../images/image30.jpg',
        isFavorite: false,
    }
]

let song_size = songs.length;

Array.from(document.getElementsByClassName('songItem')).forEach((element,i)=>{
    element.getElementsByTagName('img')[0].src = songs[i].poster;
    element.getElementsByTagName('h5')[0].innerHTML = songs[i].songName;
})

let masterPlay = document.getElementById('masterPlay');

masterPlay.addEventListener('click',()=>{
    if(music.paused || music.time <= 0){
        music.play();
        masterPlay.setAttribute('name', 'pause-circle');
        Array.from(document.getElementsByClassName('playlistPlay')).forEach((element)=>{
            if (element.getAttribute('id') == index) {
                element.setAttribute('name','pause-circle')
            }
        })
    } else{
        music.pause();
        masterPlay.setAttribute('name', 'play-circle');
        makeAllPlays();
    }
})

const makeAllPlays = () =>{
    Array.from(document.getElementsByClassName('playlistPlay')).forEach((element)=>{
        element.setAttribute('name','play-circle')
    })
}

const makeAllBackgrounds = () =>{
    Array.from(document.getElementsByClassName('songItem')).forEach((element)=>{
        element.style.background = '#0c0c29';
    })
}

let index = 0;
let poster_master_play = document.getElementById('poster_master_play');
let title = document.getElementById('title');
let fav_icon = document.getElementById('heart');

Array.from(document.getElementsByClassName('playlistPlay')).forEach((element)=>{
    element.addEventListener('click',(e)=>{
        if (element.getAttribute('name') == 'play-circle') {
            if (index != e.target.id) {
                index = parseInt(e.target.id);
                if (songs[index].isFavorite) {
                    fav_icon.setAttribute('name','heart');
                    fav_icon.style.color = 'red';
                } else {
                    fav_icon.setAttribute('name','heart-outline');
                    fav_icon.style.color = 'grey';
                }
                music.src = `../../Songs/${index}.mp3`;
                poster_master_play.src = `../../images/image${index}.jpg`;
                makeAllPlays();
                element.setAttribute('name','pause-circle');
                music.play();
                let song_title = songs.filter((ele)=>{
                    return ele.id == index;
                })

                song_title.forEach(ele => {
                    let {songName} = ele;
                    title.innerHTML = songName;
                })
                makeAllBackgrounds();
                Array.from(document.getElementsByClassName('songItem'))[`${index-1}`].style.background = '#1e1e3f';
            }
            else {
                music.play();
                masterPlay.setAttribute('name', 'pause-circle');
                element.setAttribute('name','pause-circle');
            }

            masterPlay.setAttribute('name', 'pause-circle');
        } 
        else {
            element.setAttribute('name','play-circle');
            music.pause();
            masterPlay.setAttribute('name', 'play-circle');
        }

        music.addEventListener('ended',()=>{
            masterPlay.setAttribute('name', 'play-circle');
        })
    })
})

let currentStartTime = document.getElementById('currentStart');
let currentEndTime = document.getElementById('currentEnd');
let progress = document.getElementById('progress');
let seek = document.getElementById('seek');

music.addEventListener('timeupdate', () => {
    let { currentTime } = music;
    let { duration } = music;
  
    let minutes = Math.floor(currentTime / 60);
    let seconds = Math.floor(currentTime % 60);
    seconds = seconds < 10 ? `0${seconds}` : seconds;
    currentStartTime.innerHTML = `${minutes}:${seconds}`;
  
    if (!isNaN(duration)) { // Check if duration is a valid number
      let minutes_dur = Math.floor(duration / 60);
      let seconds_dur = Math.floor(duration % 60);
      seconds_dur = seconds_dur < 10 ? `0${seconds_dur}` : seconds_dur;
      currentEndTime.innerHTML = `${minutes_dur}:${seconds_dur}`;
  
      let progress_time = parseInt((currentTime / duration) * 1000);
      progress.style.width = `${progress_time / 10}%`;
  
      if (currentTime == duration) {
        masterPlay.setAttribute('name', 'play-circle');
      }
    }
  });

seek.addEventListener('change',()=>{
    music.currentTime = seek.value * music.duration / 1000;
})

let vol_icon = document.getElementById('volume-icon');
let vol = document.getElementById('vol');
let vol_bar = document.getElementById('vol_bar');
let vol_before = 500;
let vol_icon_before = 'volume-medium-outline';

vol.addEventListener('change',()=>{
    if (vol.value == 0) {
        vol_icon.setAttribute('name','volume-mute-outline');
        vol_icon_before = 'volume-mute-outline';
    }
    else if (vol.value > 0 && vol.value <= 333) {
        vol_icon.setAttribute('name','volume-low-outline');
        vol_icon_before = 'volume-low-outline';
    }
    else if (vol.value > 333 && vol.value <= 666) {
        vol_icon.setAttribute('name','volume-medium-outline');
        vol_icon_before = 'volume-medium-outline';
    }
    else if (vol.value > 666 && vol.value <= 1000) {
        vol_icon.setAttribute('name','volume-high-outline');
        vol_icon_before = 'volume-high-outline';
    }
    let vol_value = vol.value;
    vol_before = vol_value;
    vol_bar.style.width = `${vol_value/10}%`;
    music.volume = vol_value/1000;
})

vol_icon.addEventListener('click',()=>{
    if (vol.value > 0) {
        vol.value = 0;
        vol_icon.setAttribute('name','volume-mute-outline');
        vol_bar.style.width = `0%`;
        music.volume = 0;
    }
    else if (vol.value == 0) {
        if (vol_before != 0) {
            vol_value = vol_before;
            vol_icon.setAttribute('name',vol_icon_before);
            vol_bar.style.width = `${vol_value/10}%`;
            music.volume = vol_value/1000;
            vol.value = vol_value;
        }
        else {
            vol.value = 500;
            vol_icon.setAttribute('name','volume-medium-outline');
            vol_bar.style.width = `50%`;
            music.volume = 0.5;
            vol_before = 500;
        }
    }
})

let back = document.getElementById('back');
let next = document.getElementById('next');

back.addEventListener('click',()=>{
    index = index - 1;
    if (index < 1) {
        index = song_size;
    }
    music.src = `../../Songs/${index}.mp3`;
    poster_master_play.src = `../../images/image${index}.jpg`;
    if (songs[index].isFavorite) {
        fav_icon.setAttribute('name','heart');
        fav_icon.style.color = 'red';
    } else {
        fav_icon.setAttribute('name','heart-outline');
        fav_icon.style.color = 'grey';
    }
    
    masterPlay.setAttribute('name', 'pause-circle');
    makeAllPlays();
    Array.from(document.getElementsByClassName('playlistPlay'))[`${index-1}`].setAttribute('name','pause-circle');
    music.play();
    let song_title = songs.filter((ele)=>{
        return ele.id == index;
    })

    song_title.forEach(ele => {
        let {songName} = ele;
        title.innerHTML = songName;
    })
    makeAllBackgrounds();
    Array.from(document.getElementsByClassName('songItem'))[`${index-1}`].style.background = '#1e1e3f';
})

next.addEventListener('click',()=>{
    index = index + 1;
    if (index > song_size) {
        index = 1;
    }
    music.src = `../../Songs/${index}.mp3`;
    poster_master_play.src = `../../images/image${index}.jpg`;

    if (songs[index].isFavorite) {
        fav_icon.setAttribute('name','heart');
        fav_icon.style.color = 'red';
    } else {
        fav_icon.setAttribute('name','heart-outline');
        fav_icon.style.color = 'grey';
    }

    masterPlay.setAttribute('name', 'pause-circle');
    makeAllPlays();

    Array.from(document.getElementsByClassName('playlistPlay'))[`${index-1}`].setAttribute('name','pause-circle');
    music.play();
    let song_title = songs.filter((ele)=>{
        return ele.id == index;
    })

    song_title.forEach(ele => {
        let {songName} = ele;
        title.innerHTML = songName;
    })
    makeAllBackgrounds();
    Array.from(document.getElementsByClassName('songItem'))[`${index-1}`].style.background = '#1e1e3f';
})

fav_icon.addEventListener('click',()=>{
    if (fav_icon.getAttribute('name') == 'heart-outline') {
        fav_icon.setAttribute('name', 'heart');
        fav_icon.style.color = 'red';
        songs[index].isFavorite = true;       
    }
    else {
        fav_icon.setAttribute('name', 'heart-outline');
        fav_icon.style.color = 'grey';
        songs[index].isFavorite = false;
    }
})