/**
 * 
 */

document.addEventListener('DOMContentLoaded', function () {
    const genreSelect = document.getElementById('genre');
    const genreSelect_fresh = document.getElementById('genre_fresh');
    const genreSelect_spicy = document.getElementById('genre_spicy');
    const genreSelect_relax = document.getElementById('genre_relax');
    
    
    const genreMap = {
    	'スイーツ': 'sweets-options',
        '果物': 'fruit-options',
        '飲み物': 'drink-options',
        'スパイス': 'spices-options',
        'シーン': 'scene-options',
        '植物': 'plant-options'
    };
    const genreMap1 = {
        'スイーツ1': 'sweets-options1',
        '果物1': 'fruit-options1',
		'飲み物1': 'drink-options1',
		'スパイス1': 'spices-options1',
		'シーン1': 'scene-options1',
		'植物1': 'plant-options1'
     };
    const genreMap2 = {
        	'スイーツ2': 'sweets-options2',
            '果物2': 'fruit-options2',
            '飲み物2': 'drink-options2',
            'スパイス2': 'spices-options2',
            'シーン2': 'scene-options2',
            '植物2': 'plant-options2'
        };
    const genreMap3 = {
        	'スイーツ3': 'sweets-options3',
            '果物3': 'fruit-options3',
            '飲み物3': 'drink-options3',
            'スパイス3': 'spices-options3',
            'シーン3': 'scene-options3',
            '植物3': 'plant-options3'
        };
    

    genreSelect.addEventListener('change', function () {
        const selectedGenre = genreSelect.value;
		// すべてのオプションブロックを一旦非表示にする
        Object.values(genreMap).forEach(function (id) {
            document.getElementById(id).style.display = 'none';
        });
        // 選択されたジャンルに対応するブロックだけ表示する
        if (genreMap[selectedGenre]) {
            document.getElementById(genreMap[selectedGenre]).style.display = 'block';
        }
    });
    
    genreSelect_fresh.addEventListener('change', function () {
        const selectedGenre = genreSelect_fresh.value;

        // すべてのオプションブロックを一旦非表示にする
        Object.values(genreMap1).forEach(function (id) {
            document.getElementById(id).style.display = 'none';
        });
        // 選択されたジャンルに対応するブロックだけ表示する
        if (genreMap1[selectedGenre]) {
            document.getElementById(genreMap1[selectedGenre]).style.display = 'block';
        }       
    });
    
    genreSelect_spicy.addEventListener('change', function () {
        const selectedGenre = genreSelect_spicy.value;
        // すべてのオプションブロックを一旦非表示にする
        Object.values(genreMap2).forEach(function (id) {
            document.getElementById(id).style.display = 'none';
        });
        // 選択されたジャンルに対応するブロックだけ表示する
        if (genreMap2[selectedGenre]) {
            document.getElementById(genreMap2[selectedGenre]).style.display = 'block';
        }
    });
    
    genreSelect_relax.addEventListener('change', function () {
        const selectedGenre = genreSelect_relax.value;
        // すべてのオプションブロックを一旦非表示にする
        Object.values(genreMap3).forEach(function (id) {
            document.getElementById(id).style.display = 'none';
        });
        // 選択されたジャンルに対応するブロックだけ表示する
        if (genreMap3[selectedGenre]) {
            document.getElementById(genreMap3[selectedGenre]).style.display = 'block';
        }
    });
    
 });